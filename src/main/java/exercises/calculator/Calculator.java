package exercises.calculator; /**
 * Queue and Stack Exercise
 * Give a string, and implement a calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, * operators.
 *
 * Example1: input “1+2”, output:3
 *
 * Example2: input “1+2*5”, output:11
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculator {
    StackQueue operatorStackQueue = new StackQueue();
    StackQueue numberStackQueue = new StackQueue();
    HashMap<Character, Integer> priority = new HashMap<>();

    public int calculate(String s){
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);

        parseString(s);
        calculate();

        return numberStackQueue.top();
    }
    public void operateOnStack(char newOperator){
        int n1, n2;
        while(!operatorStackQueue.isEmpty() && priority.get(operatorStackQueue.top()) >= priority.get(newOperator)) {
            n1 = numberStackQueue.pop();
            n2 = numberStackQueue.pop();
            char op = operatorStackQueue.pop();
            int ans = operate(n1, n2, op);
            numberStackQueue.push(ans);

        }
    }
    public void operateOnQueue(){
        int n1, n2;
        n1 = numberStackQueue.dequeue();
        n2 = numberStackQueue.dequeue();
        char op = operatorStackQueue.dequeue();
        int ans = operate(n1, n2, op);
        numberStackQueue.enqueue(ans);
    }
    public void parseString(String s){
        String str = "";
        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '*' || s.charAt(i) == '+' || s.charAt(i) == '-'){
                int num = Integer.parseInt(str);
                numberStackQueue.push(num);
                if(!operatorStackQueue.isEmpty() && priority.get(operatorStackQueue.top()) >= priority.get(s.charAt(i)))
                    operateOnStack(s.charAt(i));
                operatorStackQueue.push(s.charAt(i));
                str = "";
            }else{
                if(s.charAt(i) != ' ')
                    str += s.charAt(i);
            }
        }
        numberStackQueue.push(Integer.parseInt(str));
        if(!operatorStackQueue.isEmpty() && operatorStackQueue.top().toString().equals("*"))
            operateOnStack(operatorStackQueue.top());
    }
    public int operate(int n1, int n2, char op){
        int ans;
        switch (op){
            case '+':
                ans= n1+n2;
                break;
            case '*':
                ans=n1*n2;
                break;
            case '-':
                ans=n1-n2;
                break;
            default:
                ans = -1;
        }
        return ans;

    }
    public void calculate(){
        while(!operatorStackQueue.isEmpty()){
            operateOnQueue();
        }
    }
    public class StackQueue{
        List StackQueue;

        public StackQueue(){
            StackQueue = new ArrayList();
        }
        public <T> void push (T item){
            StackQueue.add(item);
        }
        public <T> T pop(){
            T item = (T) StackQueue.remove(StackQueue.size()-1);
            return item;
        }
        public <T> T top(){
            T item = (T) StackQueue.get(StackQueue.size()-1);
            return item;
        }
        public <T> void enqueue(T item){
            this.StackQueue.add(0, item);
        }
        public <T> T dequeue() {
            T item = (T) this.StackQueue.remove(0);
            return item;
        }
        public boolean isEmpty(){
            return StackQueue.size() == 0;
        }
    }
}

