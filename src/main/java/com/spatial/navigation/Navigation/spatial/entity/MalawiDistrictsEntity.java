package com.spatial.navigation.Navigation.spatial.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;
import org.locationtech.jts.geom.MultiPolygon;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="malawi_district_boundaries")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MalawiDistrictsEntity implements Serializable {
    @Id
    @GeneratedValue
    Integer gid;
    @Column(name="shape_leng")
    double shapeLength;
    @Column(name="shape_area")
    double shapeArea;
    @Column(name="local_name")
    String localName;
    @Column(name="district")
    String district;
    @Column(name="region")
    String region;
    @Column(name="country")
    String country;
    @Column(name="date")
    Date date;
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    @Column(name="geom")
    MultiPolygon geom;
}
