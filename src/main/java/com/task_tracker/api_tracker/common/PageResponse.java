package com.task_tracker.api_tracker.common;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

public class PageResponse<T> {
    private List<T> items;
    private int page;
    private int size;
    private long totalItems;
    private int totalPages;
    private boolean hasNext;
    private boolean hasPrevious;

    public static <E, T> PageResponse<T> from(Page<E> p, Function<E, T> mapper){
        PageResponse<T> r = new PageResponse<>();
        r.items = p.getContent().stream().map(mapper).toList();
        r.page = p.getNumber();
        r.size = p.getSize();
        r.totalItems = p.getTotalElements();
        r.totalPages = p.getTotalPages();
        r.hasNext = p.hasNext();
        r.hasPrevious = p.hasPrevious();

        return r;
    }

    public List<T> getItems(){
        return items;
    }
    public int getPage() { return page; }
    public int getSize() { return size; }
    public long getTotalItems() { return totalItems; }
    public int getTotalPages() { return totalPages; }
    public boolean isHasNext() { return hasNext; }
    public boolean isHasPrevious() { return hasPrevious; }
}
