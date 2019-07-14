package demo8;
// 星期的枚举
public enum WeekDay {
    // 星期一,星期五,星期天
    MON(1), FRIDAY(5), SUN(7);

    // 枚举本质是一个类,可以添加成员变量,成员方法
    private int num;
    WeekDay(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}

// 枚举的本质是一个类. 是一个多例
/*
public final class WeekDay extends Enum {
	public static final WeekDay MON = new WeekDay("MON", 0);
	public static final WeekDay FRIDAY = new WeekDay("FRIDAY", 1);
	public static final WeekDay SUN = new WeekDay("SUN", 2);

	private WeekDay(String s, int i)
	{
		super(s, i);
	}
}
 */