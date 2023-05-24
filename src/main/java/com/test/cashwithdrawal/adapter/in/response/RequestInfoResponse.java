package com.test.cashwithdrawal.adapter.in.response;

import com.test.cashwithdrawal.domain.AccountDomain.RequestInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestInfoResponse {
    private String status;

    public static RequestInfoResponse toRequestInfoResponse(RequestInfo requestInfo){
        return new RequestInfoResponse(requestInfo.getStatus());
    }
}
