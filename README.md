## spring-mybatis

#### spring-jdbc 기반에서 추가적으로 아래 실습들 진행
#### Mybatis 설정 in Spring boot autoconfiguration
#### Mybatis 설정 in Spring boot (exclude autoconfig)
#### data process with mybatis

#### TODO
1. 학생정보등록(신규학생)

2. 학생정보수정(나이 또는 이름)
    > 나이와 이름 항상 같이 vs 나이만, 이름만 같은 상황 생각

3. 강사정보 등록하기(수정 만들지 x)

4. 강의정보 등록/수정
 > 강의는 강사id를 가지고 있음.<br>
 >  강사 id가 변경되면 담당 강사가 변경됨. 꼭 존재하는 강사의 ID를 사용해야함
5. 수강신청하기 (lecture_applicants)테이블에 저장
   > 강의 정보에 capacity: 70 => 70명까지만 수강신청 가능하게
6. 수강신청한 학생들이 매일마다 출석체크(attendance)
   > 중복출석체크를 못하도록 작성