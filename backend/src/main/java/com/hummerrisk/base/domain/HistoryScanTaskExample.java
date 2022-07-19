package com.hummerrisk.base.domain;

import java.util.ArrayList;
import java.util.List;

public class HistoryScanTaskExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public HistoryScanTaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andScanIdIsNull() {
            addCriterion("scan_id is null");
            return (Criteria) this;
        }

        public Criteria andScanIdIsNotNull() {
            addCriterion("scan_id is not null");
            return (Criteria) this;
        }

        public Criteria andScanIdEqualTo(Integer value) {
            addCriterion("scan_id =", value, "scanId");
            return (Criteria) this;
        }

        public Criteria andScanIdNotEqualTo(Integer value) {
            addCriterion("scan_id <>", value, "scanId");
            return (Criteria) this;
        }

        public Criteria andScanIdGreaterThan(Integer value) {
            addCriterion("scan_id >", value, "scanId");
            return (Criteria) this;
        }

        public Criteria andScanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("scan_id >=", value, "scanId");
            return (Criteria) this;
        }

        public Criteria andScanIdLessThan(Integer value) {
            addCriterion("scan_id <", value, "scanId");
            return (Criteria) this;
        }

        public Criteria andScanIdLessThanOrEqualTo(Integer value) {
            addCriterion("scan_id <=", value, "scanId");
            return (Criteria) this;
        }

        public Criteria andScanIdIn(List<Integer> values) {
            addCriterion("scan_id in", values, "scanId");
            return (Criteria) this;
        }

        public Criteria andScanIdNotIn(List<Integer> values) {
            addCriterion("scan_id not in", values, "scanId");
            return (Criteria) this;
        }

        public Criteria andScanIdBetween(Integer value1, Integer value2) {
            addCriterion("scan_id between", value1, value2, "scanId");
            return (Criteria) this;
        }

        public Criteria andScanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("scan_id not between", value1, value2, "scanId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andOperationIsNull() {
            addCriterion("`operation` is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("`operation` is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(String value) {
            addCriterion("`operation` =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(String value) {
            addCriterion("`operation` <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(String value) {
            addCriterion("`operation` >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(String value) {
            addCriterion("`operation` >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(String value) {
            addCriterion("`operation` <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(String value) {
            addCriterion("`operation` <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLike(String value) {
            addCriterion("`operation` like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotLike(String value) {
            addCriterion("`operation` not like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<String> values) {
            addCriterion("`operation` in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<String> values) {
            addCriterion("`operation` not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(String value1, String value2) {
            addCriterion("`operation` between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(String value1, String value2) {
            addCriterion("`operation` not between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andResourcesSumIsNull() {
            addCriterion("resources_sum is null");
            return (Criteria) this;
        }

        public Criteria andResourcesSumIsNotNull() {
            addCriterion("resources_sum is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesSumEqualTo(Long value) {
            addCriterion("resources_sum =", value, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andResourcesSumNotEqualTo(Long value) {
            addCriterion("resources_sum <>", value, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andResourcesSumGreaterThan(Long value) {
            addCriterion("resources_sum >", value, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andResourcesSumGreaterThanOrEqualTo(Long value) {
            addCriterion("resources_sum >=", value, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andResourcesSumLessThan(Long value) {
            addCriterion("resources_sum <", value, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andResourcesSumLessThanOrEqualTo(Long value) {
            addCriterion("resources_sum <=", value, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andResourcesSumIn(List<Long> values) {
            addCriterion("resources_sum in", values, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andResourcesSumNotIn(List<Long> values) {
            addCriterion("resources_sum not in", values, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andResourcesSumBetween(Long value1, Long value2) {
            addCriterion("resources_sum between", value1, value2, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andResourcesSumNotBetween(Long value1, Long value2) {
            addCriterion("resources_sum not between", value1, value2, "resourcesSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumIsNull() {
            addCriterion("return_sum is null");
            return (Criteria) this;
        }

        public Criteria andReturnSumIsNotNull() {
            addCriterion("return_sum is not null");
            return (Criteria) this;
        }

        public Criteria andReturnSumEqualTo(Long value) {
            addCriterion("return_sum =", value, "returnSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumNotEqualTo(Long value) {
            addCriterion("return_sum <>", value, "returnSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumGreaterThan(Long value) {
            addCriterion("return_sum >", value, "returnSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumGreaterThanOrEqualTo(Long value) {
            addCriterion("return_sum >=", value, "returnSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumLessThan(Long value) {
            addCriterion("return_sum <", value, "returnSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumLessThanOrEqualTo(Long value) {
            addCriterion("return_sum <=", value, "returnSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumIn(List<Long> values) {
            addCriterion("return_sum in", values, "returnSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumNotIn(List<Long> values) {
            addCriterion("return_sum not in", values, "returnSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumBetween(Long value1, Long value2) {
            addCriterion("return_sum between", value1, value2, "returnSum");
            return (Criteria) this;
        }

        public Criteria andReturnSumNotBetween(Long value1, Long value2) {
            addCriterion("return_sum not between", value1, value2, "returnSum");
            return (Criteria) this;
        }

        public Criteria andScanScoreIsNull() {
            addCriterion("scan_score is null");
            return (Criteria) this;
        }

        public Criteria andScanScoreIsNotNull() {
            addCriterion("scan_score is not null");
            return (Criteria) this;
        }

        public Criteria andScanScoreEqualTo(Integer value) {
            addCriterion("scan_score =", value, "scanScore");
            return (Criteria) this;
        }

        public Criteria andScanScoreNotEqualTo(Integer value) {
            addCriterion("scan_score <>", value, "scanScore");
            return (Criteria) this;
        }

        public Criteria andScanScoreGreaterThan(Integer value) {
            addCriterion("scan_score >", value, "scanScore");
            return (Criteria) this;
        }

        public Criteria andScanScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("scan_score >=", value, "scanScore");
            return (Criteria) this;
        }

        public Criteria andScanScoreLessThan(Integer value) {
            addCriterion("scan_score <", value, "scanScore");
            return (Criteria) this;
        }

        public Criteria andScanScoreLessThanOrEqualTo(Integer value) {
            addCriterion("scan_score <=", value, "scanScore");
            return (Criteria) this;
        }

        public Criteria andScanScoreIn(List<Integer> values) {
            addCriterion("scan_score in", values, "scanScore");
            return (Criteria) this;
        }

        public Criteria andScanScoreNotIn(List<Integer> values) {
            addCriterion("scan_score not in", values, "scanScore");
            return (Criteria) this;
        }

        public Criteria andScanScoreBetween(Integer value1, Integer value2) {
            addCriterion("scan_score between", value1, value2, "scanScore");
            return (Criteria) this;
        }

        public Criteria andScanScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("scan_score not between", value1, value2, "scanScore");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(String value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(String value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(String value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(String value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLike(String value) {
            addCriterion("account_type like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotLike(String value) {
            addCriterion("account_type not like", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<String> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<String> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(String value1, String value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(String value1, String value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table history_scan_task
     *
     * @mbg.generated do_not_delete_during_merge Tue Jul 19 16:41:28 CST 2022
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table history_scan_task
     *
     * @mbg.generated Tue Jul 19 16:41:28 CST 2022
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}