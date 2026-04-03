package org.example;

/**
 * Контейнер для хранения произвольного количества целых чисел.
 * Реализован на основе массива с динамическим расширением.
 * Использование встроенных коллекций запрещено и не используется.
 */
public class IntegerContainer {

    private int[] data;
    private int size;

    /**
     * Создаёт пустой контейнер с начальной ёмкостью 10 элементов.
     */
    public IntegerContainer() {
        data = new int[10];
        size = 0;
    }

    /**
     * Добавляет число в конец контейнера.
     *
     * @param value число которое нужно добавить
     */
    public void add(int value) {
        if (size == data.length) {
            resize();
        }
        data[size] = value;
        size++;
    }

    /**
     * Возвращает элемент по индексу, не удаляя его.
     *
     * @param index индекс элемента (начиная с 0)
     * @return элемент по заданному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        return data[index];
    }

    /**
     * Удаляет элемент по индексу, сдвигая остальные элементы влево.
     *
     * @param index индекс удаляемого элемента (начиная с 0)
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    /**
     * Возвращает текущее количество элементов в контейнере.
     *
     * @return количество элементов
     */
    public int size() {
        return size;
    }

    /**
     * Увеличивает ёмкость внутреннего массива вдвое.
     */
    private void resize() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}