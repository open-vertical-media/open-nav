package me.pcaz.opennav.nav.model;

import lombok.Data;
import me.pcaz.opennav.nav.meta.ContentMeta;
import me.pcaz.opennav.nav.meta.MediumMeta;

@Data
public class DataItem {
    private ContentMeta content;
    private MediumMeta medium;
}
