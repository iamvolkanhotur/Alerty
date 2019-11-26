package com.volkanhotur.alerty;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

/*
 * Created by Volkan Hotur on 4.10.2018
 */

public class Alerty {

    public static final String ANIMATION_POP = "AnimationPop";
    public static final String ANIMATION_SLIDE = "AnimationSlide";
    public static final String ANIMATION_SIDE = "AnimationSide";
    public static final String ANIMATION_ALPHA = "AnimationAlpha";

    public static final String SMALL_TEXT = "SmallText";
    public static final String MEDIUM_TEXT = "MediumText";
    public static final String LARGE_TEXT = "LargeText";

    private String title;
    private String message;
    private String positiveButtonText;
    private String negativeButtonText;
    private String neutralButtonText;
    private int headerImage = 0;
    private int titleTextColor;
    private int messageTextColor;
    private String textAppearaence;
    private int positiveButtonColor;
    private int negativeButtonColor;
    private int neutralButtonColor;
    private int positiveButtonTextColor;
    private int negativeButtonTextColor;
    private int neutralButtonTextColor;
    private float buttonRadius;
    private float dialogRadius;
    private AlertyListener positiveListener;
    private AlertyListener negativetiveListener;
    private AlertyListener neutralListener;
    private boolean cancellable;
    private Context context;

    public Alerty(Builder builder) {
        this.title = builder.title;
        this.message = builder.message;
        this.positiveButtonText = builder.positiveButtonText;
        this.negativeButtonText = builder.negativeButtonText;
        this.neutralButtonText = builder.neutralButtonText;
        this.headerImage = builder.headerImage;
        this.titleTextColor = builder.titleTextColor;
        this.messageTextColor = builder.messageTextColor;
        this.textAppearaence = builder.textAppearance;
        this.positiveButtonColor = builder.positiveButtonColor;
        this.negativeButtonColor = builder.negativeButtonColor;
        this.neutralButtonColor = builder.neutralButtonColor;
        this.positiveButtonTextColor = builder.positiveButtonTextColor;
        this.negativeButtonTextColor = builder.negativeButtonTextColor;
        this.neutralButtonTextColor = builder.neutralButtonTextColor;
        this.buttonRadius = builder.buttonRadius;
        this.dialogRadius = builder.dialogRadius;
        this.positiveListener = builder.positiveListener;
        this.negativetiveListener = builder.negativeListener;
        this.neutralListener = builder.neutralListener;
        this.cancellable = builder.cancellable;
        this.context = builder.context;
    }

    @SuppressWarnings("UnusedReturnValue")
    public static class Builder {

        TextView alertyTitle;
        TextView alertyMessage;
        Button alertyNeutralButton;
        Button alertyNegativeButton;
        Button alertyPositiveButton;
        ImageView alertyHeader;
        CardView alertyCardView;

        private String title;
        private String message;
        private String positiveButtonText;
        private String negativeButtonText;
        private String neutralButtonText;
        private int headerImage;
        private int titleTextColor;
        private int messageTextColor;
        private String textAppearance;
        private int positiveButtonColor;
        private int negativeButtonColor;
        private int neutralButtonColor;
        private int positiveButtonTextColor;
        private int negativeButtonTextColor;
        private int neutralButtonTextColor;
        private float buttonRadius;
        private float dialogRadius;
        private AlertyListener positiveListener;
        private AlertyListener negativeListener;
        private AlertyListener neutralListener;
        private boolean cancellable = true;
        private Context context;

        private Dialog dialog;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPositiveButtonText(String positiveButtonText) {
            this.positiveButtonText = positiveButtonText;
            return this;
        }

        public Builder setNegativeButtonText(String negativeButtonText) {
            this.negativeButtonText = negativeButtonText;
            return this;
        }

        public Builder setNeutralButtonText(String neutralButtonText) {
            this.neutralButtonText = neutralButtonText;
            return this;
        }

        public Builder setPositiveButtonColor(int positiveButtonColor) {
            this.positiveButtonColor = positiveButtonColor;
            return this;
        }

        public Builder setNegativeButtonColor(int negativeButtonColor) {
            this.negativeButtonColor = negativeButtonColor;
            return this;
        }

        public Builder setNeutralButtonColor(int neutralButtonColor) {
            this.neutralButtonColor = neutralButtonColor;
            return this;
        }

        public Builder setHeaderImage(int headerImage) {
            this.headerImage = headerImage;
            return this;
        }

        public Builder setPositiveListener(AlertyListener positiveListener) {
            this.positiveListener = positiveListener;
            return this;
        }

        public Builder setNegativeListener(AlertyListener negativeListener) {
            this.negativeListener = negativeListener;
            return this;
        }

        public Builder setNeutralListener(AlertyListener neutralListener) {
            this.neutralListener = neutralListener;
            return this;
        }

        public Builder setCancellable(boolean cancellable) {
            this.cancellable = cancellable;
            return this;
        }

        public Builder setButtonRadius(float buttonRadius) {
            this.buttonRadius = buttonRadius;
            return this;
        }

        public Builder setDialogRadius(float dialogRadius) {
            this.dialogRadius = dialogRadius;
            return this;
        }

        public Builder setTitleTextColor(int titleTextColor) {
            this.titleTextColor = titleTextColor;
            return this;
        }

        public Builder setMessageTextColor(int messageTextColor) {
            this.messageTextColor = messageTextColor;
            return this;
        }

        public Builder setTextAppearance(String textAppearance) {
            this.textAppearance = textAppearance;
            return this;
        }

        public Builder setPositiveButtonTextColor(int positiveButtonTextColor) {
            this.positiveButtonTextColor = positiveButtonTextColor;
            return this;
        }

        public Builder setNegativeButtonTextColor(int negativeButtonTextColor) {
            this.negativeButtonTextColor = negativeButtonTextColor;
            return this;
        }

        public Builder setNeutralButtonTextColor(int neutralButtonTextColor) {
            this.neutralButtonTextColor = neutralButtonTextColor;
            return this;
        }

        public Dialog getDialog() {
            return dialog;
        }

        public Alerty build() {
            dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(cancellable);
            dialog.setCanceledOnTouchOutside(cancellable);
            dialog.setContentView(R.layout.alerty_standart_dialog);

            alertyTitle = dialog.findViewById(R.id.alerty_title);
            alertyMessage = dialog.findViewById(R.id.alerty_message);
            alertyHeader = dialog.findViewById(R.id.alerty_header);
            alertyPositiveButton = dialog.findViewById(R.id.alerty_positive_button);
            alertyNegativeButton = dialog.findViewById(R.id.alerty_negative_button);
            alertyNeutralButton = dialog.findViewById(R.id.alerty_neutral_button);
            alertyCardView = dialog.findViewById(R.id.alerty_card_view);

            GradientDrawable positiveBG = (GradientDrawable) alertyPositiveButton.getBackground();
            GradientDrawable negativeBG = (GradientDrawable) alertyNegativeButton.getBackground();
            GradientDrawable neutralBG = (GradientDrawable) alertyNeutralButton.getBackground();

            alertyTitle.setText(title);
            alertyMessage.setText(message);

            alertyPositiveButton.setVisibility(positiveButtonText != null ? View.VISIBLE : View.GONE);
            alertyNegativeButton.setVisibility(negativeButtonText != null ? View.VISIBLE : View.GONE);
            alertyNeutralButton.setVisibility(neutralButtonText != null ? View.VISIBLE : View.GONE);

            alertyPositiveButton.setText(positiveButtonText);
            alertyNegativeButton.setText(negativeButtonText);
            alertyNeutralButton.setText(neutralButtonText);

            if(textAppearance != null){
                switch (textAppearance){
                    case SMALL_TEXT:
                        alertyTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                        alertyMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                        alertyPositiveButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                        alertyNegativeButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                        alertyNeutralButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                        break;

                    case LARGE_TEXT:
                        alertyTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                        alertyMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                        alertyPositiveButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                        alertyNegativeButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                        alertyNeutralButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                        break;

                    case MEDIUM_TEXT:
                    default:
                        alertyTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                        alertyMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                        alertyPositiveButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                        alertyNegativeButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                        alertyNeutralButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                        break;
                }
            }

            if(titleTextColor != 0){
                alertyTitle.setTextColor(titleTextColor);
            }

            if(messageTextColor != 0){
                alertyMessage.setTextColor(messageTextColor);
            }

            if(headerImage != 0){
                alertyHeader.setImageResource(headerImage);
                alertyHeader.setVisibility(View.VISIBLE);
            }else {
                alertyHeader.setVisibility(View.GONE);
            }

            if(positiveButtonTextColor != 0){
                alertyPositiveButton.setTextColor(positiveButtonTextColor);
            }

            if(negativeButtonTextColor != 0){
                alertyNegativeButton.setTextColor(negativeButtonTextColor);
            }

            if(neutralButtonTextColor != 0){
                alertyNeutralButton.setTextColor(neutralButtonTextColor);
            }

            if (positiveButtonColor != 0) {
                positiveBG.setColor(positiveButtonColor);
            }

            if (negativeButtonColor != 0) {
                negativeBG.setColor(negativeButtonColor);
            }

            if (neutralButtonColor != 0) {
                neutralBG.setColor(neutralButtonColor);
            }

            if (buttonRadius > 0) {
                positiveBG.setCornerRadius(buttonRadius);
                negativeBG.setCornerRadius(buttonRadius);
                neutralBG.setCornerRadius(buttonRadius);
            }

            if(dialogRadius > 0){
                alertyCardView.setRadius(dialogRadius);
            }

            if (positiveListener != null) {
                alertyPositiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        positiveListener.onDialogClick(dialog);
                    }
                });
            }else {
                alertyPositiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }

            if (negativeListener != null) {
                alertyNegativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        negativeListener.onDialogClick(dialog);
                    }
                });
            }else {
                alertyNegativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }

            if (neutralListener != null) {
                alertyNeutralButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        neutralListener.onDialogClick(dialog);
                    }
                });
            }else {
                alertyNeutralButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }

            dialog.show();

            return new Alerty(this);
        }
    }
}
