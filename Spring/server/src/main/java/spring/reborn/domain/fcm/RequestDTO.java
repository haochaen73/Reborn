package spring.reborn.domain.fcm;

import lombok.*;

@AllArgsConstructor
@Data
public class RequestDTO {
    private String title;
    private String body;
    private String targetToken;
}