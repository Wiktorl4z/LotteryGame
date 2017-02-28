package com.example.l4z.lotterygame;


public enum Sound {
    SOUND_ONE (R.raw.sound_one),SOUND_TWO(R.raw.sound_two),SOUND_THREE(R.raw.sound_three);

    private int sound;

    Sound(int sound) {
       this.sound = sound;
    }

    public int getSound() {
        return sound;
    }
}
