package org.elisha.faslelisha.models;

import android.graphics.Picture;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Fady on 29-Sep-16.
 */
@IgnoreExtraProperties
public class Boy {
    private int id;
    private String name;
    private Picture profilePicture;
    private int totalPoints;
    private int attendance;
    private int usedPoints;
    private int remainingPoints;

    public Boy() {
    }

    public Boy(int id, String name, Picture profilePicture, int totalPoints, int attendance, int usedPoints, int remainingPoints) {
        this.id = id;
        this.name = name;
        this.profilePicture = profilePicture;
        this.totalPoints = totalPoints;
        this.attendance = attendance;
        this.usedPoints = usedPoints;
        this.remainingPoints = remainingPoints;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        result.put("profilePicture", profilePicture);
        result.put("totalPoints", totalPoints);
        result.put("attendance", attendance);
        result.put("usedPoints", usedPoints);
        result.put("remainingPoints", remainingPoints);

        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getUsedPoints() {
        return usedPoints;
    }

    public void setUsedPoints(int usedPoints) {
        this.usedPoints = usedPoints;
    }

    public int getRemainingPoints() {
        return remainingPoints;
    }

    public void setRemainingPoints(int remainingPoints) {
        this.remainingPoints = remainingPoints;
    }
}
