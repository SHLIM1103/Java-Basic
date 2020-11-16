package util;
// 배열을 사용하는데 도움이 되는 메소드를 모아둔 BoardUtil 클래스

import day07.Board;

public class BoardUtil {

    // 파라미터로 넘어온 int[]을 출력하는 print 메소드
    public static void print(String arrayName, int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("%s[%d]: %d\n", arrayName, i, intArray[i]);
        }
    }

    // 파라미터로 넘어온 int[]을 오름차순으로 정렬하는 sortByASC 메소드
    public static void sortByASC(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > intArray[i + 1]) {
                int tmp = intArray[i];
                intArray[i] = intArray[i + 1];
                intArray[i + 1] = tmp;
                i = -1;
            }
        }
    }

    // 파라미터로 넘어온 int[]을 내림차순으로 정렬하는 sortByDESC 메소드
    public static void sortByDESC(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < intArray[i + 1]) {
                int tmp = intArray[i];
                intArray[i] = intArray[i + 1];
                intArray[i + 1] = tmp;
                i = -1;
            }
        }
    }

    // 파라미터로 넘어온 int[]에서 같이 넘어온 숫자가 존재하는지 아닌지 판별하는 contains 메소드
    // 존재하면 true, 존재하지 않으면 false를 리턴한다
    public static boolean contains(int[] intArray, int number) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == number) {
                return true;
            }
        }
        return false;
    }

    // 동적할당에 관련된 메소드들
    // 1. int[]의 크기를 확인하여 return하는 size 메소드
    public static int size(int[] intArray) {
        return intArray.length;
    }

    // 2. int[]에 파라미터로 넘어온 int를 항상 마지막 칸에 추가해주는 add 메소드
    public static int[] add(int[] intArray, int element) {
        int size = size(intArray);
        int[] tmp = new int[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = intArray[i];
        }
        intArray = new int[size + 1];
        for (int i = 0; i < size; i++) {
            intArray[i] = tmp[i];
        }
        intArray[size] = element;

        return intArray;
    }

    // 사용자가 배열과 index를 넘기면 해당 배열에서 인덱스를 삭제하고 크기가 줄어든 배열을 리턴하는 removeByIndex 메소드
    public static int[] removeByIndex(int[] array, int index) {
        int size = size(array);
        if (index < 0 || index > size - 1) {
            return array;
        }
        int tmp[] = new int[size];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = array[i];
        }
        array = new int[size - 1];

        if (index == 0) {
            for (int i = 1; i < size; i++) {
                array[i - 1] = tmp[i];
            }
        } else if (index == size - 1) {
            for (int i = 0; i < size - 1; i++) {
                array[i] = tmp[i];
            }

        } else {
            for (int i = 0; i < (index - 1); i++) {
                array[i] = tmp[i];
            }
            for (int i = (index + 1); i < tmp.length; i++) {
                array[i - 1] = tmp[i];
            }
        }
        return array;

    }

    // 해당 배열에서 특정 요소가 몇번 인덱스에 있는지 확인하는 indexOf 메소드
    // 단, 해당 배열에서 그 요소가 존재하지 않으면 -1을 return한다.
    public static int indexOf(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // 인덱스가 아니라 파라미터로 넘어온 element와 동일한 element를 삭제하는 remove 메소드
    public static int[] remove(int[] array, int element) {
        return removeByIndex(array, indexOf(array, element));
    }

    // 현재 우리가 만든 메소드들 중에서 add, indexOf, removeByIndex, remove, contains를 
    // String 기준으로 오버로딩 해서 만들어라
    public static String[] add(String[] array, String element) {
        int size = array.length;
        String[] tmp = new String[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = array[i];
        }
        array = new String[size + 1];
        for (int i = 0; i < size; i++) {
            array[i] = tmp[i];
        }
        array[size] = element;

        return array;
    }

    public static int indexOf(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public static String[] removeByIndex(String[] array, int index) {
        if (index < 0 || index > array.length - 1) {
            return array;
        }

        String[] tmp = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        array = new String[tmp.length - 1];

        if (index == 0) {
            for (int i = 1; i < tmp.length; i++) {
                array[i - 1] = tmp[i];
            }

        } else if (index == tmp.length - 1) {
            for (int i = 0; i < tmp.length - 1; i++) {
                array[i] = tmp[i];
            }
        } else {
            for (int i = 0; i < index; i++) {
                array[i] = tmp[i];
            }
            for (int i = (index + 1); i < tmp.length; i++) {
                array[i - 1] = tmp[i];
            }
        }
        return array;
    }

    public String[] remove(String[] array, String element) {
        return removeByIndex(array, indexOf(array, element));
    }

    public boolean contains(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Board 구조체에 대한 메소드들
    // 1. contains
    public static boolean contains(Board[] array, Board b) {
        for(int i = 0 ; i < array.length ; i++) {
            if(array[i].getNo() == b.getNo()) {
                return true;
            }
        }
        return false ;
    }


    // 2. indexOf
    public static int indexOf(Board[] array, Board b) {
        for(int i = 0 ; i < array.length ; i++) {
            if(array[i].getNo() == b.getNo()) {
                return i ;
            }
        }
        return -1 ;
    }


    // 3. add 
    public static Board[] add(Board[] array, Board b) {
        Board[] tmp = new Board[array.length];
        for(int i = 0 ; i < array.length ; i++) {
            tmp[i] = array[i];
        }
        array = new Board[tmp.length+1];
        for(int i = 0 ; i < tmp.length ; i++) {
            array[i] = tmp[i];            
        }
        array[tmp.length] = b ;

        return array;
    }


    // 4. removeByIndex
    public static Board[] removeByIndex(Board[] array, int index) {
        if(index < 0 || index > array.length-1) {
            return array ;
        }

        Board[] tmp = new Board[array.length];
        for(int i = 0 ; i < array.length ; i++) {
            tmp[i] = array[i];
        }

        array = new Board[tmp.length - 1];

        if(index == 0) {
            for(int i = 1 ; i < tmp.length ; i++) {
                array[i-1] = tmp[i];
            }

        }else if(index == tmp.length-1) {
            for(int i = 0 ; i < tmp.length-1 ; i++) {
                array[i] = tmp[i] ;
            }
        }else {
            for(int i = 0 ; i < index ; i++) {
                array[i] = tmp[i] ;
            }
            for(int i = (index+1) ; i < tmp.length ; i++) {
                array[i-1] = tmp[i];
            }    
        }

        return array ;
    }

    // 5. remove 를 작성하시오.
    public static Board[] remove(Board[] array, Board b) {
        return removeByIndex(array, indexOf(array, b));
    }


    // 6. size를 작성하시오.
    public static int size(Board[] array) {
        return array.length;
    }





}
