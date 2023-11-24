class Item {
    int d; // ключ
    Item left;
    Item right;

    // конструктор
    Item(int value) {
        d = value;
    }
}

class Tree {
    Item root; // корень дерева

    // формирование корня дерева
    void init(int value) {
        Item pv = new Item(value);
        pv.left = null;
        pv.right = null;
        root = pv;
    }

    // поиск с включением
    void searchInsert(int value) {
        Item pv = root;
        Item prev = null;
        while (pv != null) {
            prev = pv;
            if (value == pv.d)
                return;
            else if (value < pv.d)
                pv = pv.left;
            else
                pv = pv.right;
        }
        // Создание нового узла
        Item pnew = new Item(value);
        pnew.left = null;
        pnew.right = null;
        if (value < prev.d)
            prev.left = pnew; // присоединение к левому поддереву предка
        else
            prev.right = pnew; // присоединение к правому поддереву предка
    }

    // Поиск элемента в дереве
    Item search(int value) {
        Item pv = root;
        while (pv != null) {
            if (value == pv.d)
                return pv;
            else if (value < pv.d)
                pv = pv.left;
            else
                pv = pv.right;
        }
        return null; // элемент не найден
    }

    // Обход дерева
    void printTree(Item p) {
        if (p != null) {
            System.out.println(" " + p.d);
            printTree(p.left); // вывод левого поддерева
            printTree(p.right); // вывод правого поддерева
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int b[] = { 10, 25, 20, 6, 21, 8, 1, 30 };
        Tree m = new Tree();
        m.init(b[0]);
        for (int i = 1; i < 8; i++)
            m.searchInsert(b[i]);

        System.out.println("Элементы в дереве:");
        m.printTree(m.root);

        int element = 21;
        Item n_element = m.search(element);

        if (n_element != null) {
            System.out.println("Элемент " + element + " найден в дереве.");
        } else {
            System.out.println("Элемент " + element + " не найден в дереве.");
        }
    }
}