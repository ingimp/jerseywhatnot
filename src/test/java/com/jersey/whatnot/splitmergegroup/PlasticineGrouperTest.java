package com.jersey.whatnot.splitmergegroup;

import com.google.common.base.Predicate;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PlasticineGrouperTest {

    private List<PlasticineEntity> plasticines;
    private List<List<PlasticineEntity>> plasticineGroups;

    @Before
    public void setUp() throws Exception {
        plasticines = new PlasticineReader().readPlasticines();
        plasticineGroups = new PlasticineGrouper().groupPlastines(plasticines);
    }

    @Test
    public void should_group_single_plasticine() throws Exception {
        //id为1的橡皮泥自己是一组
        assertTrue(thereIsAGroupThatHasAndOnlyHas(plasticineGroups, 1));
    }

    @Test
    public void should_group_split_plasticine() throws Exception {
        //2被拆分成了3和4
        assertTrue(thereIsAGroupThatHasAndOnlyHas(plasticineGroups, 2, 3, 4));
    }

    @Test
    public void should_group_merge_plasticine() throws Exception {
        //7是由5和6合并出来的
        assertTrue(thereIsAGroupThatHasAndOnlyHas(plasticineGroups, 5, 6, 7));
    }

    @Test
    public void should_group_split_merge_plasticine() throws Exception {
        //橡皮泥8拆出了9和10
        //橡皮泥11拆出了12和13
        //最后，9和12合并成了14
        assertTrue(thereIsAGroupThatHasAndOnlyHas(plasticineGroups, 8, 10, 11, 13, 14));
    }

    @Test
    public void should_group_merge_split_plasticine() throws Exception {
        //15和16合并成了17
        //17被拆分成了18和19
        assertTrue(thereIsAGroupThatHasAndOnlyHas(plasticineGroups, 15, 16, 18, 19));
    }

    @Test
    public void should_group_split_multiple_plasticines() throws Exception {
        //20被拆分成了21和22
        //21被拆分成了23和24
        //23被拆分成了25和26
        assertTrue(thereIsAGroupThatHasAndOnlyHas(plasticineGroups, 20, 22, 24, 25, 26));
    }

    @Test
    public void should_only_have_6_groups() throws Exception {
        //分组结果不应该有重复，应该仅仅有6个分组
        //参考flyway的seed脚本
        assertThat(plasticineGroups.size(), is(6));
    }

    private boolean thereIsAGroupThatHasAndOnlyHas(List<List<PlasticineEntity>> plasticineGroups, final Integer... ids) {
        return from(plasticineGroups).anyMatch(new Predicate<List<PlasticineEntity>>() {
            @Override
            public boolean apply(List<PlasticineEntity> group) {
                return hasAndOnlyHas(group, ids);
            }
        });
    }

    private boolean hasAndOnlyHas(final List<PlasticineEntity> group, final Integer... ids) {
        return from(asList(ids)).allMatch(new Predicate<Integer>() {
            @Override
            public boolean apply(final Integer id) {
                return from(group).anyMatch(new Predicate<PlasticineEntity>() {
                    @Override
                    public boolean apply(PlasticineEntity plasticine) {
                        return plasticine.getId() == id;
                    }
                });
            }
        }) && group.size() == ids.length;
    }
}
