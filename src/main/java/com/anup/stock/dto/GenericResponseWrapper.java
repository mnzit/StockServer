package com.anup.stock.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Manjit Shakya <manjit.shakya@f1soft.com>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseWrapper implements Serializable {

    private Integer resultCode;
    private String resultDescription;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;
}
