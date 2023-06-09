package com.ddockddack.domain.multigame.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class StarredGameRes {
    private Long gameId;
    private String gameTitle;
    private String gameDesc;
    private String creator;
    private int isStarred;
    private int starredCnt;
    private int popularity;
    private String thumbnail;

    @QueryProjection
    public StarredGameRes(Long gameId, String gameTitle, String gameDesc, String creator, int isStarred, int starredCnt, int popularity, String thumbnail) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.gameDesc = gameDesc;
        this.creator = creator;
        this.isStarred = isStarred;
        this.starredCnt = starredCnt;
        this.popularity = popularity;
        this.thumbnail = thumbnail;
    }
}
