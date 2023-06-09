package com.ddockddack.domain.gameroom.response;

import com.ddockddack.domain.gameroom.entity.GameMember;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class GameMemberRes {

    private String socketId;
    private String nickname;
    private String image;
    private int roundScore;
    private int scaledRoundScore;
    private int totalScore;

    //    매 라운드가 끝날때마다 response 반환, 마지막 라운드에는 누적값(totalScore)를 roundScore 에 담아 반환.
    @Builder
    public GameMemberRes(String socketId, String nickname, String image, int roundScore,
        int scaledRoundScore, int totalScore) {
        this.socketId = socketId;
        this.image = image;
        this.roundScore = roundScore;
        this.scaledRoundScore = scaledRoundScore;
        this.totalScore = totalScore;
        this.nickname = nickname;
    }

    public static GameMemberRes of(GameMember gameMember, int round) {
        return GameMemberRes.builder()
            .socketId(gameMember.getSocketId())
            .nickname(gameMember.getNickname())
            .image(gameMember.getImages().get(round))
            .roundScore(gameMember.getRoundScore())
            .scaledRoundScore(gameMember.getScaledRoundScore())
            .build();
    }

    public static GameMemberRes from(GameMember gameMember) {
        return GameMemberRes.builder()
            .socketId(gameMember.getSocketId())
            .nickname(gameMember.getNickname())
            .totalScore(gameMember.getTotalScore())
            .build();
    }
}
