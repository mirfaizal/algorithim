package com.basicjava;

public class DocumentCounter {

    public static class Counter {
        private int count = 0;
        private int increment;

        public Counter(int increment) {
            this.increment = increment;
        }

        public int getAndIncrement() {
            this.count += this.increment;
            return this.count;
        }
    }

    public static class DocumentNameCreator {
        private Counter counter;
        private String prefix;
        public DocumentNameCreator(int increment, String prefix) {
            this.counter = new Counter(increment);
            this.prefix = prefix;
        }

        public String getNewDocumentName() {
            return prefix +  this.counter.getAndIncrement();
        }
    }
}