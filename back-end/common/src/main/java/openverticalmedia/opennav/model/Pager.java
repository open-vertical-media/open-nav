package openverticalmedia.opennav.model;

import lombok.Data;

import java.util.List;

@Data
public class Pager<D> {
    private long count;
    private List<D> data;
}
