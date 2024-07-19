public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        // ваш код
        // возьмите value из последнего узла
        // назначьте предыдущий к последнему узлу последним узлом
        int v = tail.getValue();
        Node prev = tail.getPrev();
        tail = prev;
        this.size -= 1;
        return v;
    }

    public int getSize() {
        // ваш код
        // верните размер стека
        return this.size;
    }

    public boolean isEmpty() {
        // ваш код
        // верните ответ на вопрос, не пустой ли стек
        return this.getSize() == 0;
    }

    public String toString() {
        // если есть элементы, пройдитесь по связному списку,
        // выводя элементы.
        // вывод должен быть в точности как в комментариях к main
        // при этом этот метод не должен менять стек!
        if (isEmpty()) {
            return "EMPTY";
        }

        StringBuilder s = new StringBuilder();
        s.append(tail.getValue());
        Node prev = tail.getPrev();
        int i = size;
        while (i > 1) {
            s.append("-> ").append(prev.getValue());
            prev = prev.getPrev();
            i -= 1;
        }

        return s.toString();
    }
}
