package ru.msk.java.webfluxmonotest.demo.processing;

import lombok.ToString;

@ToString
public class Response {
        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
}
