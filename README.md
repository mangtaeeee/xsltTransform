# XSLT Example Project

## 개요
이 프로젝트는 **XML 데이터를 XSLT를 사용하여 HTML로 변환**하는 간단한 예제입니다.  
XSLT의 기본 개념과 사용법을 학습하기 위한 목적으로 작성되었습니다.  

---

## 프로젝트 구조
```
.
├── data.xml           # 변환 대상 XML 데이터
├── style.xsl          # XSLT 변환 규칙
├── output.html        # 변환 결과 (HTML)
└── README.md
```

---

## 실행 방법

### 1. 브라우저에서 직접 확인
일부 브라우저(예: Chrome, Firefox)는 XML 파일을 열었을 때 `<?xml-stylesheet?>` 지시어를 통해 자동 변환을 지원합니다.  
`data.xml` 상단에 다음과 같이 선언하면, 브라우저에서 XML을 열 때 XSLT가 적용됩니다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="style.xsl"?>
<root>
  ...
</root>
```

### 2. 명령어로 변환 (xsltproc 사용)
리눅스/macOS 환경에서 `xsltproc` 명령어를 이용해 변환할 수도 있습니다.

```bash
xsltproc style.xsl data.xml > output.html
```

이렇게 하면 `output.html` 파일이 생성됩니다.

---

## 예제 코드

### data.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="style.xsl"?>
<books>
  <book>
    <title>운영체제</title>
    <author>김태윤</author>
  </book>
  <book>
    <title>네트워크</title>
    <author>홍길동</author>
  </book>
</books>
```

### style.xsl
```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <head><title>Book List</title></head>
      <body>
        <h2>도서 목록</h2>
        <ul>
          <xsl:for-each select="books/book">
            <li>
              <xsl:value-of select="title"/> - <xsl:value-of select="author"/>
            </li>
          </xsl:for-each>
        </ul>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
```

---

## 참고
- [W3C XSLT 문서](https://www.w3.org/TR/xslt/)  
- [MDN Web Docs - XSLT](https://developer.mozilla.org/ko/docs/Web/XSLT)
