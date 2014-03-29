package com.jersey.whatnot.splitmergegroup;

import com.google.common.base.Predicate;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

public class PlasticineGrouperTest {

    private List<PlasticineEntity> plasticines;

    @Before
    public void setUp() throws Exception {
        plasticines = new PlasticineReader().readPlasticines();
    }

    @Test
    public void should_group_single_plasticine() throws Exception {
        //分组
        List<List<PlasticineEntity>> plasticineGroups = new PlasticineGrouper().groupPlastines(plasticines);

        //id为1的橡皮泥自己是一组
        assertTrue(thereIsAGroupThatHasAndOnlyHas(plasticineGroups, 1));
    }

    @Test
    public void should_group_split_plasticine() throws Exception {
        //分组
        List<List<PlasticineEntity>> plasticineGroups = new PlasticineGrouper().groupPlastines(plasticines);

        //2被拆分成了3和4
        assertTrue(thereIsAGroupThatHasAndOnlyHas(plasticineGroups, 2, 3, 4));
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
