package com.spatial.navigation.Navigation.spatial.hateos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spatial.navigation.Navigation.spatial.entity.MalawiDistrictsEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.locationtech.jts.geom.MultiPolygon;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Relation(collectionRelation = "areas", itemRelation = "area")
@JsonPropertyOrder({"localName","district","region","country","geometry"})
public class MalawiDistrictsDto extends RepresentationModel<MalawiDistrictsDto> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String localName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String district;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String region;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String country;

    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    MultiPolygon geometry;

    public static MalawiDistrictsDto build(MalawiDistrictsEntity entity){
        return MalawiDistrictsDto.builder()
                .district(entity.getDistrict())
                .country(entity.getCountry())
                .localName(entity.getLocalName())
                .region(entity.getRegion())
                .geometry(entity.getGeom())
                .build();
    }
}
