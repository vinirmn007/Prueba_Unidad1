package com.prueba1.stack;

import com.prueba1.list.*;

public class StackOperation<E> extends LinkedList<E> {
    private Integer top;

    public StackOperation(Integer top) {
        this.top = top;
    }

    public boolean verify () {
        return getSize().intValue() <= top.intValue();
    }

    public void push(E dato) throws Exception {
        if (verify()) {
            add(dato, 0);
        } else {
            throw new OverFlowException("pila llena");
        }
    }
    public E pop() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("pila vacia");
        } else {
            return deleteFirst();
        }
        
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

}
