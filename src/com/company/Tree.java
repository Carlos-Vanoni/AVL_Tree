package com.company;

public class Tree {
    private Node root;

    public Tree() {
        this.root = new Node();
    }

    public void insert(Integer newValue){
        root.insert(newValue);
        checkBalance(root);
    }

    public void print(){
        root.print(0);
    }

    public boolean search(Integer value){
        return root.search(value);
    }

    public void checkBalance(Node n){
        if (n.getValue() != null){
            Integer factor = n.getFactor();
            if (factor > 1){
                if (n.getLeft().getFactor() > 0){
                    n = rotateRight(n);
                } else if (n.getLeft().getFactor() < 0){

                }
            }
            if (factor < -1){
                if (n.getRight().getFactor() < 0){
                    n = n.rotateLeft();
                }
            }
        }
        if (n.getRight() != null) {
            checkBalance(n.getRight());
        }
        if (n.getLeft() != null) {
            checkBalance(n.getLeft());
        }
    }

    public Node rotateRight(Node father){
//        Node newNode = father.getLeft();
//        newNode.setRight(father);
//        //father.setLeft(newNode.getRight());
//        //newNode.setRight(father);
//        return newNode;
//        //node.height = max(node.getLeft(), node.getRight) + 1;

        Integer aux80 = father.getLeft().getLeft().getValue();
        Integer aux110 = father.getValue();
        Integer aux100 = father.getLeft().getValue();

        Node resultado = new Node(aux100);
        resultado.setRight(new Node(aux80));
        resultado.setLeft(new Node(aux110));
        //resultado.setLeft(aux80);

//        father = aux100;
//        father.setLeft(aux80);
//        father.setRight(aux110);
        return resultado;


    }
}
