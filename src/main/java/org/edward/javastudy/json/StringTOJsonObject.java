package org.edward.javastudy.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class StringTOJsonObject {

    public static void main(String[] args) {
        String jsonData = "{'name':'John', 'comment':''}";
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        Person p = gson.fromJson(jsonData, Person.class);
        System.out.println(p);
    }

    class Person {
        String name;
        Integer age;
        String comment = "ab";

        public String toString() {

            return "name :" + name + " age:" + age + " comment:" + comment;
        }
    }

    static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

            Class<T> rawType = (Class<T>) type.getRawType();

            if (rawType == Integer.class) {
                return (TypeAdapter<T>) new IntegerAdapter();
            }

            if (rawType != String.class) {
                return null;
            }


            return (TypeAdapter<T>) new StringAdapter();
        }
    }

    static class StringAdapter extends TypeAdapter<String> {
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "-888";
            }
            return reader.nextString();
        }

        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }

    static class IntegerAdapter extends TypeAdapter<Integer> {
        public Integer read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return new Integer("-999");
            }
            return reader.nextInt();
        }

        public void write(JsonWriter writer, Integer value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
}
