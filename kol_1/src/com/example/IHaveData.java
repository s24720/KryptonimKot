package com.example;

import java.util.List;

public interface IHaveData<TItem> {
    List<TItem> getData();

    public void showData();
}
