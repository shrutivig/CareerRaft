package careerraft.app.android.sec.com.careerraft;

/**
 * Created by sagar on 29/03/16.
 */
public class CobbocEvent {
    public static final int LOGIN = 1;
    public static final int LOGOUT = 2;
    public static final int SIGN_UP = 3;
    public static final int FORGOT_PASSWORD = 4;
    public static final int GET_RAFT_DETAIL_CATEGORY = 5;
    public static final int OTP_VERIFICATION = 6;


    private boolean STATUS;

    private int TYPE;

    private Object VALUE;

    public CobbocEvent(int type) {
        this(type, true, null);
    }

    public CobbocEvent(int type, boolean status) {
        this(type, status, null);
    }

    public CobbocEvent(int type, boolean status, Object value) {
        TYPE = type;
        STATUS = status;
        VALUE = value;
    }

    public CobbocEvent(int type, boolean status, int value) {
        TYPE = type;
        STATUS = status;
        VALUE = Integer.valueOf(value);
    }

    public boolean getStatus() {
        return STATUS;
    }



    public int getType() {
        return TYPE;
    }

    public Object getValue() {
        return VALUE;
    }
}
