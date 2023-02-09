package spring.reborn.domain.reborn.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRebornReq {
    private int storeIdx;
    private String productName;
    private String productGuide;
    private String productComment;
    private String productImg;
    private String productLimitTime;
    private int productCnt;
}
