package com.example.DoAnJava.models;

import lombok.Data;
import java.util.List;

@Data
public class TestDTO {
    private String testName;
    private List<PartDTO> parts;

    @Data
    public static class PartDTO {
        private Integer partNumber;
        private String partType;
        private List<QuestionDTO> questions;

        @Data
        public static class QuestionDTO {
            private Integer questionNumber;
            private String questionText;
            private String imageURL;
            private String audioURL;
            private List<ChoiceDTO> choices;

            @Data
            public static class ChoiceDTO {
                private String choiceText;
                private Boolean isCorrect;
            }
        }
    }
}
