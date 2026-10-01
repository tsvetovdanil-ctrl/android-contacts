package ru.yandex.practicum.contacts.utils.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import ru.yandex.practicum.contacts.presentation.base.ListDiffInterface;

public class BaseListDiffCallback<T extends ListDiffInterface<T>> extends DiffUtil.Callback {

    private final List<T> oldList;
    private final List<T> newList;

    public BaseListDiffCallback(List<T> oldList, List<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        T oldItem = oldList.get(oldItemPosition);
        T newItem = newList.get(newItemPosition);

        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        T oldItem = oldList.get(oldItemPosition);
        T newItem = newList.get(newItemPosition);
        // Использую метод интерфейса ListDiffInterface
        return oldItem.theSameAs(newItem);
    }
}