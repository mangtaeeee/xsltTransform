<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- 루트 매칭 -->
    <xsl:template match="/">
        <html>
            <body>
                <h2>책 목록</h2>
                <table border="1" cellpadding="5">
                    <tr>
                        <th>제목</th>
                        <th>저자</th>
                    </tr>
                    <!-- books/book 반복 -->
                    <xsl:for-each select="books/book">
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="author"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>