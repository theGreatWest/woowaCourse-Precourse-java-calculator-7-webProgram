package com.example.calculator_7_webProgram.utility;

public class CheckValueCorrect {
    public String value;

    public CheckValueCorrect(){}
    public CheckValueCorrect(String inputValue) {
        this.value = inputValue;
    }

    // 정수 또는 실수 결정
    public boolean determineType(String o){
        try {
            Integer intValue = Integer.parseInt(o);
            return true;
        } catch (NumberFormatException e) {
            try {
                Double doubleValue = Double.parseDouble(o);
                return false;
            } catch (NumberFormatException ex) { }
        }
        return true;
    }

    // 정수나 실수로 변환 가능한 값인지 체크
    public Object parseNumber(String input) {
        try {
            Integer intValue = Integer.parseInt(input);
            return intValue;
        } catch (NumberFormatException e) {
            try {
                Double doubleValue = Double.parseDouble(input);
                return doubleValue;
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("입력값을 정수나 실수로 변환할 수 없습니다.");
            }
        }
    }

    // 0보다 작은지 체크
    public boolean isNegative(Object number) {
        if (number instanceof Integer) {
            return (Integer) number < 0;
        } else if (number instanceof Double) {
            return (Double) number < 0;
        }
        return false;
    }

    public Object strToNum(String inputValue){
        this.value = inputValue;
        Object changeValue;

        try{
            changeValue = parseNumber(this.value);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("-".repeat(58)+"\n" +
                    "정수로 변환할 수 없는 값이 감지되었습니다. 아래의 형식에 맞게 입력해 주세요.\n" +
                    "➣ 커스텀 구분자 지정시, //와 \\n를 모두 사용하며 순서를 지켜야 합니다.\n" +
                    "➣ 구분자를 제외한 모든 문자는 양수인 정수여야 합니다.\n");
        }

        if (isNegative(changeValue)) {
            throw new IllegalArgumentException("-".repeat(58) + "\n" +
                    "음수를 입력하였습니다. 양수인 정수를 입력해 주세요.\n");
        }

        return changeValue;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "입력된 변수: " + this.value;
    }
}
