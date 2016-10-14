package sys.dto;

/**
 * author: zf
 * Date: 2016/9/1  14:30
 * Description:
 */
public class SearchConditions {
    /**
     * 分页相关
     */
    private Integer pageIndex = 1;
    private Integer pageSize = 10;
    private Integer recordStart = 0;
// 搜索参数：字符串，int值，时间段
    private String  searchName;

    private Integer intValue;

    private Integer ageType;


    public Integer getAgeType() {
        return ageType;
    }

    public void setAgeType(Integer ageType) {
        this.ageType = ageType;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    /**
     * 权限相关
     * @return
     */

    public Integer getRecordStart() {
        return recordStart;
    }

    public void setRecordStart(Integer recordStart) {
        this.recordStart = recordStart;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
        int start = (this.getPageIndex()-1)*this.getPageSize();
        this.setRecordStart(start);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        int start = (this.getPageIndex()-1)*this.getPageSize();
        this.setRecordStart(start);
    }

    @Override
    public String toString() {
        return "SearchConditions{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", recordStart=" + recordStart +
                ", searchName='" + searchName + '\'' +
                ", intValue=" + intValue +
                ", ageType=" + ageType +
                '}';
    }
}
