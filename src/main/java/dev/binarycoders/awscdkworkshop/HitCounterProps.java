package dev.binarycoders.awscdkworkshop;

import software.amazon.awscdk.services.lambda.IFunction;

public interface HitCounterProps {

    // Public constructor for the props builder
    static Builder builder() {
        return new Builder();
    }

    IFunction getDownstream();

    // The builder for the props interface
    class Builder {
        private IFunction downstream;

        public Builder downstream(final IFunction function) {
            this.downstream = function;
            return this;
        }

        public HitCounterProps build() {
            if (this.downstream == null) {
                throw new NullPointerException("The downstream property is required!");
            }

            return new HitCounterProps() {
                @Override
                public IFunction getDownstream() {
                    return downstream;
                }
            };
        }
    }
}
