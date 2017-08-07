package com.self.ddyoung.daily.service;

import org.junit.Test;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/3/10 下午6:18
 */
public class ChapterTest  extends AutoRollbackBaseTest {

    private Chapter chapter;

    @Test
    public void testMain() throws Exception {
        chapter.mainOne(1000000);
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}