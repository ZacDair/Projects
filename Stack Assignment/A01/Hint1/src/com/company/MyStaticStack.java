package com.company;
/**
 * ADT MyStack: Private Part<br>.
 * The class implements all the operations available in MyStack<br>
 */
public class MyStaticStack implements MyStack {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------
    private int items[];
    private int numItems;
    private int maxItems;
    private int poppedItem;

    //-------------------------------------------------------------------
    // Basic Operation --> Check if myStack is empty: myCreateEmpty
    //-------------------------------------------------------------------
    //public myStack myCreateEmpty(){}

    public MyStaticStack(int m){
        this.maxItems = m;
        this.numItems = 0;
        this.items = new int[this.maxItems];

    }

    //-------------------------------------------------------------------
    // Basic Operation --> Check if MyStack is empty: isEmpty
    //-------------------------------------------------------------------

    public boolean isEmpty(){
        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        boolean res = true;

        //-----------------------------
        //SET OF OPS
        //-----------------------------


        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario = 0;
        if (numItems != 0){
            scenario = 1;
        }
        else{
            scenario = 2;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch(scenario) {
            //Rule 1. if the number of items isn't 0
            case 1:
                res = false;
                break;

            //Rule 2. if the number of items is 0
            case 2:
                res = true;
                break;
        }
        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Get and remove first element from top of MyStack: pop
    //-------------------------------------------------------------------

    public int pop(){
        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        int res = -1;

        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario = 0;
        //Rule 1. if there is 0 items remove nothing
        if (numItems == 0){
            scenario = 1;
        }
        //Rule 2. if there is more than 0 items remove top item
        else{
            scenario = 2;
        }

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch(scenario) {

            //Rule 1. if there is 0 items remove nothing
            case 1:
                System.out.println("Unable to pop an element, Stack is empty");
                poppedItem = 0;
                break;

            //Rule 2. if there is more than 0 items remove top item
            case 2:
                int i = 0;
                poppedItem = items[i];
                for (i = 0;i < 2; i++){
                    items[i] = items[i+1];
                }
                items[2] = 0;
                numItems--;
                break;
        }
        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return poppedItem;
    }


    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Add element to the top of MyStack: push
    //-------------------------------------------------------------------

    public void push(int element){
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        //Rule 1. if there is room for more elements
        int scenario = 0;
        if (numItems < maxItems){
            scenario = 1;
        }
        //Rule 2. if there is room no for more elements
        else{
            scenario = 2;
        }

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch(scenario) {
            //Rule 1. if there is space for more elements add a new item into the top push down all others
            case 1:
                for (int i = 2;i >0; i--){
                    items[i] = items[i-1];
                }
                items[0] = element;
                numItems++;
                break;

            //Rule 2. if there is no space for more elements
            case 2:
                System.out.println("Unable to push a new element, Stack is full");
                break;
        }


    }

    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> prints all the elements from MyStack: print
    //-------------------------------------------------------------------

    public void print(){

        //-----------------------------
        //SET OF OPS
        //-----------------------------
        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        //Rule 1. if the stack is empty
        int scenario = 0;
        if (numItems == 0){
            scenario = 1;
        }
        //Rule 2. if the stack is full

        else{
            scenario = 2;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch(scenario) {
            //Rule 1. if its an empty stack
            case 1:
                System.out.print(" The Stack is empty");
                break;

            //Rule 2. if its a full stack
            case 2:
                for (int i = 0; i<=2;i++){
                    System.out.print(items[i]);
                }
                System.out.print( " The Stack is full");
                break;
        }

    }

}
