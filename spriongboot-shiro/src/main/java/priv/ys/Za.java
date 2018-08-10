package priv.ys;

public class Za {
    public static void main(String[] args) {
        /*
        1应到工作21.75
        缺勤工作日9.75


        实际到12天
        基本工资5000
        实发工资2758.62
        餐补240
        全勤0奖金0迟到
        合计工资2998.62
        7月1日-7月31月






 @Id
    @GeneratedValue
    private Long id;
    private String name;//名称

    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;//资源类型 menu|button

    private String url;//资源路径
    private String permission;//权限字符串，menu例子：role：create，role：update，role：delete，role：view
    private Long parentId;//父编号
    private String parentIds;//父编号列表
    private Boolean available = Boolean.FALSE;

    //角色-权限对应关系
    @ManyToMany
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "permissionId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roles;

    public Long getId() {
        return id;
    }

     还刘越200
     房租2000
     电费200

     京东1497.19-640=857
     花呗460.61
     爱学

     差不多还1500多

        房租2000
        电费300
        话费80
        公交120
        饭300
        面膜60
        学费200
        电影4*30=120
2900

5000+460+


28.94
20.53

2 2 30





明天：买菜
      小朋友
      洗被子

















        * */
        double shijiday=12;

        double shiji=2998.62;
        double jia=3000.0;
        double zhen=5000.0;

        System.out.println(1497.19-640);
        System.out.println("jia"+(shiji/jia));
        System.out.println(16.0/31);
    }
}
