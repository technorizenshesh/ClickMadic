package com.technorizen.crysco.Constant;

public class BaseClass {
    private String BaseUrl = "https://insys.website/crysco/webservice/";

    public static BaseClass get() {
        return new BaseClass();
    }

    public String Login() {
        return BaseUrl.concat("login");
    }

    public String registerMobile() {
        return BaseUrl.concat("register_mobile");
    }

    public String checkOtp() {
        return BaseUrl.concat("check_otp");
    }

    public String resendOtp() {
        return BaseUrl.concat("resend_otp");
    }

    public String updateProfile() {
        return BaseUrl.concat("update_profile");
    }

    public String NearBy() {
        return BaseUrl.concat("NearBy");
    }

    public String getHealthTips() {
        return BaseUrl.concat("get_health_tips");
    }

    public String getOffers() {
        return BaseUrl.concat("offerlist");
    }

    public String getProfile() {
        return BaseUrl.concat("get_profiles");
    }

    public String getUserSlot() {
        return BaseUrl.concat("get_user_time_slot");
    }

    public String add_booking() {
        return BaseUrl.concat("add_booking");
    }

    public String get_booking() {
        return BaseUrl.concat("get_booking_userid");
    }
    public String addFavDoctor() {
        return BaseUrl.concat("add_fav_doctor");
    }
    public String getFavDoctor() { return BaseUrl.concat("get_fav_doctor_list"); }
    public String cancelBooking() { return BaseUrl.concat("cancel_booking"); }
    public String search_doctor() { return BaseUrl.concat("search_doctor"); }
    public String get_chat() { return BaseUrl.concat("get_chat"); }
    public String insert_chat() { return BaseUrl.concat("insert_chat"); }
}
