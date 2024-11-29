# AverageCalculator

# [Branch](https://github.com/gmlwls96/AverageCalculator/branches) 전략 #

* main
    * **Release** 를 위한 브랜치
* develop
    * 피처개발, 버그픽스 를 위한 브랜치
    * 각 스프린트마다 모든 피처개발, 버그픽스는 **develop** 브랜치에만 머지한다.
    * 릴리즈 시 develop 브랜치를 main 브랜치로 merge
    * `[ave-이슈번호]  -> ave-5` 형식으로 브랜치 생성
* hotfix
    * hotfix 할 일이 있을 경우에 사용.
    * main 브랜치로 merge

# CommitMessage Guide

* 화면 개발 시 다음과 같은 prefix 사용 ```(feature)[#이슈 번호] title```
* 코어 개발, 리펙토링 시 다음과 같은 prefix 사용 ```(eng)[#이슈 번호] title```
* 버그 픽스 시 다음과 같은 prefix 사용 ```(fix)[#이슈 번호] title```
* 문서 작업 시 다음과 같은 prefix 사용 ```(doc)[#이슈 번호] title```

# [Pull-Request](https://github.com/gmlwls96/AverageCalculator/pulls) 전략 #

* 모든 브랜치는 **pull-request** 를 통해 머지 요청한다.
* 모든 pr은 **ci(build, test, lint)** 를 통과해야한다.
* 모든 pr은 최소 한명이상의 리뷰를 **approve** 받아야 머지한다.
    * 리뷰대기자는 리뷰가 늦어 질 경우 오프라인, 온라인으로 적극적으로 요청한다.
    * 리뷰어는 작업 시작 시 항상 리뷰할 코드가 있는지 확인한다.
* 모든 작업은 티켓을 생성해서 작업한다.

# CodeReview Guide
* 코드 리뷰는 감정을 베재하고 이성적으로 한다.
* 리뷰어는 조금이라도 궁금하거나, 자신의 생각과 다르다면 일단 코멘트를 작성한다.
* PR을 올린 사람은, 코멘트에 대해 적절한 답변 혹은 코드 반영 후 커밋로그를 답변에 추가한다.
  * ```  2341djla21 에 반영했습니다.  or [이러이러 해서] [이렇게] 했습니다. 확인부탁드립니다. ```
* 리뷰어의 코멘트에 작성자가 답변 및 커밋 메세지를 확인 후 리뷰어는 코멘트에 대한 답변이 충실했다면, `resolve conversion` 후 `approve` 한다
* 작성자는 모든 코멘트가 처리 되고, `PR` 이 `approve` 되었다면, merge 한다. 

# 코딩 컨벤션

**detekt**의 룰을 따른다. 임의로 혼자 수정하지않고, 수정 필요시 팀과 논의한다.