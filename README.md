# Short URL Generator
- 긴 URL을 BASE62로 변환하여 짧은 URL로 변경해 제공하는 서비스를 구현

## 사용 환경
- java 16
- mysql 8.0.20
- spring boot
- intellij

## 각 페이지 목표 및 구현사항

### Home Page

- Page URL: `/`
- `destination URL`에 대한 `short URL`을 생성할 수 있습니다.
- 동일한 `destination URL`을 입력하면 매번 다른 `short URL`을 생성합니다.
- `short URL`이 생성되면 해당 `short URL`의 detail 페이지로 이동합니다.
- `index.html` 파일을 참고해 화면을 노출합니다.

### Short URL

- Page URL: `/{short URL}`
- URL 접근시 `short URL`에 매핑된 `destination URL`로 redirect 시킵니다.
- URL 접근시 클라이언트 `access log`를 남깁니다.

### Short URL Detail Page

- Page URL: `/{short url}/detail`
- 생성된 `short URL`의 상세 정보를 확인할 수 있습니다.
- 생성된 `short URL`로의 `access log`를 확인할 수 있습니다.
- `detail.html` 파일을 참고해 화면을 노출합니다.

#### URL Details

| Name            | Description       |
|-----------------|-------------------|
| Destination URL | 원본 url link       |
| Short URL       | short url link    | 
| Created At      | short url이 생성된 시간 |
| Total Clicks    | short url 클릭 횟수   | 
| Last Clicked At | 마지막 클릭 시간         |

#### Access Log

| Name       | Description      |
|------------|------------------|
| IP         | 클라이언트 IP         |
| User Agent | 클라이언트 user agent |
| Referrer   | 이전 페이지 referrer  |
| Clicked At | 클릭한 시간           |

### Error Page

- 유효하지 않는 `short url`로 접근한 경우 `error.html` 파일을 참고해 화면를 노출합니다.
