package com.spatial.navigation.Navigation.spatial.hateos;

import com.spatial.navigation.Navigation.spatial.entity.MalawiDistrictsEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class MalawiDistrictsAssembler implements RepresentationModelAssembler<MalawiDistrictsEntity,MalawiDistrictsDto> {
    @Override
    public MalawiDistrictsDto toModel(MalawiDistrictsEntity entity) {
        return MalawiDistrictsDto.build(entity);
    }

    @Override
    public CollectionModel<MalawiDistrictsDto> toCollectionModel(Iterable<? extends MalawiDistrictsEntity> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
