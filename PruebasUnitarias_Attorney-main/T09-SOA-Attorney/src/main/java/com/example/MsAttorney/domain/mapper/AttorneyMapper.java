package com.example.MsAttorney.domain.mapper;

import com.example.MsAttorney.domain.dto.AttorneyRequestDto;
import com.example.MsAttorney.domain.dto.AttorneyResponseDto;
import com.example.MsAttorney.domain.model.Attorney;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AttorneyMapper {

    public static Attorney toModel(AttorneyRequestDto dto){
        return new Attorney(
                dto.getName(),
                dto.getFatherlastname(),
                dto.getMotherlastname(),
                dto.getDni(),
                dto.getCellphone(),
                dto.getAddress(),
                dto.getActive()
        );
    }

    public static Attorney toModel(Integer id, AttorneyRequestDto dto){
        return new Attorney(
                id,
                dto.getName(),
                dto.getFatherlastname(),
                dto.getMotherlastname(),
                dto.getDni(),
                dto.getCellphone(),
                dto.getAddress(),
                dto.getActive()
        );
    }

    public static AttorneyResponseDto toDto(Attorney model){
        return new AttorneyResponseDto(
                model.getId(),
                model.getName(),
                model.getFatherlastname(),
                model.getMotherlastname(),
                model.getDni(),
                model.getCellphone(),
                model.getAddress(),
                model.getActive()
        );
    }
}
