package com.github.lcguerrerocovo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by luisguerrero on 2/3/17.
 */
class CompanyZ {


    public static void main(String[] args) {

        Stack stack = (new CompanyZ()).new Stack();

        System.out.println("\nparking charges");
        System.out.println(solution("00:00","00:59"));
        System.out.println(solution("10:00","13:21"));
        System.out.println(solution("09:42","11:42"));
        System.out.println(solution("00:00","23:59"));

        System.out.println("\nstack operations");
        System.out.println(solution("13 DUP 4 POP 5 DUP + DUP + -",stack));
        System.out.println(solution("5 6 + -",stack));
        System.out.println(solution("3 DUP 5 - -",stack));
        System.out.println(solution("",stack));
        System.out.println(solution("" + ((int)(Math.pow(2,20)-10)) + " " + 9 + " +",stack));
        System.out.println(solution("" + ((int)(Math.pow(2,20)-10)) + " " + 9 + " +",stack));
        System.out.println(solution("" + ((int)(Math.pow(2,20)-10)) + " " + 10 + " +",stack));

        System.out.println("\nsmallest unsorted consecutive sequence");
        System.out.println(solution(new int[]{1,2,6,5,5,8,9}));
        System.out.println(solution(new int[]{1,2,3,4,5,6,7}));
    }

    public static int solution(String E, String L) {
        int entranceFee = 2;
        int firstHour = 3;
        int recurringHour = 4;
        int totalFee = entranceFee + firstHour;

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date start;
        Date end;
        try {
            start = df.parse(E);
            end = df.parse(L);
        } catch (ParseException e) {
            throw new RuntimeException("Date is in invalid format", e);
        }

        long sMin = TimeUnit.MILLISECONDS.toMinutes(start.toInstant().toEpochMilli());
        long eMin = TimeUnit.MILLISECONDS.toMinutes(end.toInstant().toEpochMilli());

        long duration = (eMin - sMin)/60;

        if (duration > 1) {
            if(eMin%60 == sMin%60) duration -= 1;
            totalFee += duration * recurringHour;
        }

        return totalFee;
    }

    public static int solution(String S, Stack stack) {
        try {
            String[] ops = S.split(" ");

            for (String op: ops) {
                stack.op(op);
            }
            return stack.pop();

        } catch(RuntimeException e) {
            return -1;
        }
    }

    public static int solution(int[] A) {
        if(A.length > 0) {
            int[] sortedA = Arrays.copyOf(A, A.length);
            Arrays.sort(sortedA);

            int start = 0;
            int end = A.length - 1;
            for (int i = 0, j = A.length - 1; (i < A.length / 2 + 1 && j >= A.length / 2 - 1); i++, j--) {
                if (A[i] != sortedA[i]) {
                    start = i;
                }
                if (A[j] != sortedA[j]) {
                    end = j;
                }
                if (start != 0 && end != A.length - 1)
                    break;
            }

            if ((end + 1) - start == A.length) return 0;
            else return (end + 1) - start;
        } else return 0;
    }

    class Stack {

        private LinkedList<Integer> stack = new LinkedList<>();

        public void push(Integer n) {
            stack.addFirst(n);
        }

        public Integer pop() {
            if (!stack.isEmpty()) {
                return stack.removeFirst();
            }
            throw new RuntimeException("no integers to pop from stack");
        }

        public Integer dup() {
            if (!stack.isEmpty()) {
                int first = stack.getFirst();
                push(first);
                return first;
            }
            throw new RuntimeException("no integers to dup from stack");
        }

        public Integer sum() {
            if (stack.size() > 1) {
                Long sum = ((long) pop()) + ((long) pop());
                if (sum <= Math.pow(2, 20) - 1) {
                    push(sum.intValue());
                    return sum.intValue();
                }
            }
            throw new RuntimeException("no integers to sum from stack");
        }

        public Integer diff() {
            if (stack.size() > 1) {
                int diff = pop() - pop();
                if (diff >= 0) {
                    push(diff);
                    return diff;
                }
            }
            throw new RuntimeException("no integers to find difference from stack");
        }

        public void op(String op) {
            switch (op) {
                case "POP":
                    pop();
                    break;
                case "DUP":
                    dup();
                    break;
                case "+":
                    sum();
                    break;
                case "-":
                    diff();
                    break;
                default:
                    try {
                        push(Integer.parseInt(op));
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("invalid operation in sequence");
                    }
                    break;
            }
        }

        public String toString() {
            return Arrays.deepToString(stack.toArray());
        }
    }

}
