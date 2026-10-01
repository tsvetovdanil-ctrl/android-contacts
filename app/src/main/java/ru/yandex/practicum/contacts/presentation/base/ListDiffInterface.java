package ru.yandex.practicum.contacts.presentation.base;

public interface ListDiffInterface<T> {

    // 1 метод проверяет одинаковы ли объекты по содержимому
    boolean theSameAs(T item);

    // 2 метод переопределяет equals из Object делая его обязательным
    @Override
    boolean equals(Object o);
}