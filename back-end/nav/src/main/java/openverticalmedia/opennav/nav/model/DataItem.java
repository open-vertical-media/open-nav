package openverticalmedia.opennav.nav.model;

import lombok.Data;
import openverticalmedia.opennav.nav.meta.ContentMeta;
import openverticalmedia.opennav.nav.meta.MediumMeta;

@Data
public class DataItem {
    private ContentMeta content;
    private MediumMeta medium;
}
