package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircleCalculator {
    private final List<Double> savedData = new ArrayList<>();
    private Integer radius;
    private double result;
    public static final double PIE = Math.PI;  // 상수임을 명시하기 위해 대문자로 명명
        // static:클래스 로딩 시 한 번만 메모리에 올라감. 객체 생성 없이도 클래스 이름으로 접근 가능 -> public으로 외부접근 허용
        // final: 한번 정의 된 후 변하지 않는 값(파이 값은 변하지 않으므로)
    public CircleCalculator(){};

    public CircleCalculator(int radius) {
        this.radius = radius;
    }

    public double circleExtent() {
        result = radius * radius * PIE ;
        System.out.println("원의 넓이는 "+result+"입니다.");
        this.save(result);
        return result;
    }

    public void save(double num) {
        savedData.add(num);
        System.out.println("계산한 원 넓이가 저장되었습니다.");
    }

    public Integer readyCircle(Scanner sc) {
        System.out.println("입력하신 반지름의 원 넓이를 구합니다.");

        while(true){
            System.out.print("계산하고 싶은 원의 반지름을 입력해주세요.(소수 불가): ");
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("exit")){
                System.out.println("작업이 종료됩니다.");
                return null;
            }
            if(input.trim().isEmpty()){
                System.out.print("입력값이 없습니다. 다시 입력해주세요: ");
                continue;
            }
            try{
                radius = Integer.parseInt(input);
                break;
            } catch(NumberFormatException e){
                System.out.println("잘못 입력하였습니다. 정수를 입력해주세요");
            }
        }
        return radius;
    }

    public void finishCircle(Scanner sc) {
        while(true){
            System.out.println();
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
            System.out.println("현재 저장되어있는 모든값을 삭제 하시겠습니까? ('clear'입력)");
            System.out.println();
            System.out.println("더 계산하길 원하시면 'enter키'를, 종료를 원하시면 'exit'을 입력해주세요: ");

            String answer = sc.nextLine();

            if(answer.equalsIgnoreCase("remove")) {
                if(!this.getData().isEmpty()){
                    System.out.println("저장된 첫 번째 "+this.getData().get(0)+"이 삭제됩니다.");
                    this.getData().remove(0);
                    System.out.println("현재 저장된 값은 "+this.getData() + " 입니다.");
                } else {
                    System.out.println("삭제할 값이 없습니다.");
                }
            } else if(answer.equalsIgnoreCase("inquiry")){
                System.out.print("현재 계산기에 저장된 값은 ");
                if(!this.getData().isEmpty()){
                    for(double num : this.getData()){
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }else {
                    System.out.println("현재 저장되어 있는 값이 없습니다.");
                }
            } else if (answer.equalsIgnoreCase("clear")) {
                System.out.println("계산기에 저장된 모든 값을 삭제합니다.");
                this.getData().clear();
            } else if ( answer.equalsIgnoreCase("exit")){
                System.out.println("작업이 종료됩니다.");
                return;
            } else if (answer.isBlank()){
                Integer input = this.readyCircle(sc);
                if(input == null){  // <- exit 를 입력한 경우
                    System.out.println("작업이 종료됩니다. ");
                    return;
                }
                this.setValues(input);
                this.circleExtent();
            }else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    // getter 메서드
    public List<Double> getData() {
        return savedData;
    }

    public Integer getRadius(){
        return this.radius;
    }

    //setter 메서드
    public void setValues(int radius) {
        this.radius = radius;
    }

}
