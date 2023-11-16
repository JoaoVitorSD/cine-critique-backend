package softeng.cinecritique.app.domain;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageModel<T>{

    List<T> content;
    int totalPages;
    Long totalElements;
    int size;

    int page;

    public PageModel(List<T> content, int totalPages, Long totalElements, int size, int page) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.page = page;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public <U> PageModel<U> map(Function<? super T, ? extends U> converter){
        return new PageModel<>(content.stream().map(converter).collect(Collectors.toList()), totalPages, totalElements, size, page);
    }
}
