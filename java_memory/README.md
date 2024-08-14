
# Понимание JVM


``
public class JvmComprehension {

    public static void main(String[] args) {
        int i = 1;                      // 1
        Object o = new Object();        // 2
        Integer ii = 2;                 // 3
        printAll(o, i, ii);             // 4
        System.out.println("finished"); // 7
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5
        System.out.println(o.toString() + i + ii);  // 6
    }
}
``

1. Загружаются класса в метаспейс с помощью ClassLoader.
2. В стеке создается фрейм main
3. 1 В фрейм main записывется простая переменная int i = 1
4. 2 Создается в куче объект Object. Ссылка o на него записывается в фрейм main
5. 3 Создается объект ii в куче, а ссылка на объект в стеке в фрейм main
6. 4 Cоздается в стеке новый фрейм для вызова метода printAll. В этом фрейме передаются ссылка на объект о, примитивное значение i, ссылка на объект ii.
7. 5 В хипе создается объект uselessVar. В фрейме printAll создается на него ссылка.
8. 6 Метод toString создает новый фрейм. Создается новый объект в хипе. Метод println создает новую строку в хипе. Выводит результат на экран.
9. В хипе создается строка "finished", ссылка на нее в стеке и выводится в консоль.
10. Завершается стек main. Его фрейм удаляется. Так как больше нет ссылок на объекты, то они удаляются сборщиком мусора.
